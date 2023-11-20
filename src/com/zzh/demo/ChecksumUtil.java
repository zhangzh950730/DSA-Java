package com.zzh.demo;

/**
 * 该类提供校验和的功能，计算校验和、检查校验和、计算1的补码和
 * @author thb
 *
 */
public class ChecksumUtil {

	/**
	 * 根据输入的字节数组数据计算校验和。校验和就是RFC1071描述的校验和
	 * @param sourceData 输入数据
	 * @return 16比特位的校验和
	 */
	public static short calculateChecksum(byte[] sourceData) {
		short checksum;

		// 计算1的补码和
		checksum = calculateOnesComplementSum(sourceData);
		// 将1的补码和取反，即0变1，1变0，就是校验和
		checksum = (short)(~checksum);
		return checksum;
	}

	/**
	 * 验证校验和
	 * 因为接收到的数据中包含了发送端填写的校验，所以接收端对接收到的数据计算
	 * 1的补码和，如果结果全为1，校验正确；否则，校验错误。
	 * @param receivedData 接收端收到的数据，其中最后两个字节是校验和
	 * @return true：检查成功， false:检查失败
	 */
	public static boolean checkChecksum(byte[] receivedData) {
		short onesComplementSum;

		if ((receivedData.length % 2) == 0) {
			 // 如果传入的数据是偶数个字节，那么直接计算1的补码和
			onesComplementSum = calculateOnesComplementSum(receivedData);
		} else {
			// 如果传入的数据是奇数个字节，要在数据后面补一个字节0x00，后面再跟两个字节的校验和
			// 构造一个数据数组，偶数个字节
			byte[] data = new byte[receivedData.length + 1];
			// 将原数据(除校验和两个字段外)先拷贝到data中
			System.arraycopy(receivedData, 0, data, 0, receivedData.length - 2);
			// 数据后面最后一个字节填充0x00
			data[data.length - 3] = (byte)0x00;
			// 将校验和两个字节拷贝到data中
			System.arraycopy(receivedData, receivedData.length - 2 , data, data.length - 2, 2);
			// 计算1的补码和
			onesComplementSum = calculateOnesComplementSum(data);
		}

		return onesComplementSum == (short)0xFFFF;
	}

	/**
	 * 根据输入的字节数组数据计算16比特位的1的补码和（1's complement sum）。
	 * 就是将输入数据每两个字节组成一个16比特位的整数，然后将该整数系列二进制相加，
	 * 并经超过最高有效位的进位丢弃，并经该丢弃的进位加到最低有效位上。
	 * @param data 输入数据
	 * @return 16比特位的1的补码和
	 */
	public static short calculateOnesComplementSum(byte[] data) {
		// 考虑到进位，所以中间结果用32比特位的整数存放，高位两个字节存储的是进位
		int middleSum = 0;

		for (int i = 0; i < data.length; i += 2) {
			if (data.length % 2 == 0) { // 输入数据的总字节数是偶数
				// 将两个相邻的字节组合成一个整数，并和前面的整数和相加
				middleSum += ((0xFF00 & (data[i] << 8)) | (0x00FF & data[i + 1]));
			} else {  // 输入数据的总字节数是奇数
				// 如果已经到了数据的最后一个字节，后面要补一个各bit位全为0的字节
				if (i == (data.length - 1)) {
					middleSum += ((0xFF00 & (data[i] << 8)) | (0x00FF & 0x00));
				} else {
					middleSum += ((0xFF00 & (data[i] << 8)) | (0x00FF & data[i + 1]));
				}
			}
		}

		// 定义进位变量
		short carries;
		// 将进位取出来
		carries = (short)((middleSum & 0xFFFF0000) >> 16);
		// 因为将进位加到后面两个字节上，可能又产生了进位，所以要用循环判断处理，
		// 直到不产生进位了为止
		while (carries != 0) {
			// 将sum的前面两个字节清零，准备下面的计算
			middleSum = (middleSum & 0x0000FFFF);
			// 将进位加到后面两个字节上
			middleSum += carries;
			// 将进位再取出来，因为上面相加后可能又产生了进位
			carries = (short)((middleSum & 0xFFFF0000) >> 16);
		}

		// 将上面计算结果的低端2个字节取出来返回，就是1的补码和
		return (short)(middleSum & 0x0000FFFF);
	}
}
