package practiceJava;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;

public class PracticeJava8 {

	public static void main(String[] args) {

		/*
		 * Lambda式
		 */
//		SampleInterface sampleInterface = (name) -> {
//			System.out.println("Hello, " + name);
//		};
//		sampleInterface.say("World");



/////////////////////////////////////////////////////////////////////
//		IsNumberInterface isNumberInterface = (String value) -> {
//			try{
//				new BigDecimal(value);
//				return true;
//			} catch (Exception e) {
//				return false;
//			}
//		};
/////////////////////////////////////////////////////////////////////

		//    上記は以下のように省略可能

/////////////////////////////////////////////////////////////////////
//		IsNumberInterface isNumberInterface = (value) -> {
//			try{
//				new BigDecimal(value);
//				return true;
//			} catch (Exception e) {
//				return false;
//			}
//		};
/////////////////////////////////////////////////////////////////////

		//   上記は以下のように省略可能(引数が一つの場合のみ)

//		IsNumberInterface isNumberInterface = value -> {
//			try{
//				new BigDecimal(value);
//				return true;
//			} catch (Exception e) {
//				return false;
//			}
//		};
//
//		System.out.println(isNumberInterface.check("100a"));



		// 以下別パターン
		// {}とreturnがない形式
		//(普通にラムダ式を書くと)
//		IsNumberInterface isNumberInterface = value -> {
//			return "100".equals(value);
//		};
//		System.out.println(isNumberInterface.check("100"));


		//({}とreturnを省略する形式)
//		IsNumberInterface isNumberInterface = value -> "100".equals(value);
//		System.out.println(isNumberInterface.check("100"));


		/*
		 * foreach と メソッド参照
		 */
//		List<String> stringList = Arrays.asList("Hello", "World");
//
//		System.out.println("------- 通常for文 -------");
//		//通常for文
//		for(int i=0;i<stringList.size(); i++) {
//			System.out.println(stringList.get(i));
//		}
//
//		System.out.println("------- 拡張for文 -------");
//		//拡張for文
//		for(String str : stringList) {
//			System.out.println(str);
//		}
//
//		System.out.println("------- ラムダ式 省略なし -------");
//		//ラムダ式 省略せず
//		stringList.forEach((String s) -> System.out.println(s));
//
//		System.out.println("------- ラムダ式 省略あり -------");
//		//ラムダ式 省略
//		stringList.forEach(s -> System.out.println(s));
//
//		System.out.println("------- ラムダ式 メソッド参照 -------");
//		//ラムダ式 メソッド参照
//		stringList.forEach(System.out::println);


		/*
		 * StreamAPI
		 *
		 * ※リストの扱いが簡略化できる
		 */
		//準備
//		List<String> numList = new ArrayList<>();
//		for(int i=0; i<1000000; i++) {
//			numList.add(String.valueOf(i));
//		}
//
//		//Java7以前
//		long start = System.nanoTime();
//		int rtn = 0;
//		for(String numStr : numList) {
//			int num = Integer.parseInt(numStr);
//			if(num % 2 == 0) {
//				rtn += num;
//			}
//		}
//		long end = System.nanoTime();
//		System.out.println("rtn = " + rtn);
//		System.out.println("time = " + (end - start));
//
//		System.out.println("");
//		System.out.println("-------------------------------------");
//		System.out.println("");
//
//		//Java8以降
//		start = System.nanoTime();
//		rtn = 0;
//		rtn = numList.stream()
//				.mapToInt(Integer::parseInt)
//				.filter(num -> num % 2 == 0)
//				.sum();
//		end = System.nanoTime();
//		System.out.println("rtn = " + rtn);
//		System.out.println("time = " + (end - start));
//
//		System.out.println("");
//		System.out.println("-------------------------------------");
//		System.out.println("");
//
//		//Java8以降
//		start = System.nanoTime();
//		rtn = 0;
//		rtn = numList.parallelStream()
//				.mapToInt(Integer::parseInt)
//				.filter(num -> num % 2 == 0)
//				.sum();
//		end = System.nanoTime();
//		System.out.println("rtn = " + rtn);
//		System.out.println("time = " + (end - start));



		/*
		 * Optionalクラス
		 */
		//Optionalクラス定義
////		Optional<String> name = Optional.ofNullable(null);
//		Optional<String> name = Optional.ofNullable("hello");
//		//Optinalクラスに格納されている値を使用
//		System.out.println(name.get());
//		//nameがnull出ない場合に引数のメソッドを実行
//		name.ifPresent(System.out::println);
//		System.out.println("end");


		/*
		 * インターフェースのデフォルトメソッド
		 */
////		DefaultMethodInterface defaultMethod = new DefaultMethodInterface() {};
//		DefaultMethodInterface defaultMethod = new DefaultMethodInterface() {
//			@Override
//			public String getName() {
//				return "実装したよ";
//			}
//
//		};
//		System.out.println(defaultMethod.getName());


		/*
		 * 新TimeAPI
		 */
		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.MAY, 10, 15, 35, 55);
		System.out.println("localdatetime = " + localDateTime);

		OffsetDateTime offsetDateTime = OffsetDateTime.of(2015, 3, 10, 15, 35, 55, 0, ZoneOffset.of("+09:00"));
		System.out.println("offsetdatetime = " + offsetDateTime);

		JapaneseDate japaneseDate = JapaneseDate.of(JapaneseEra.HEISEI, 27, 5, 5);
        System.out.println("japaneseDate = "+japaneseDate);

        ZonedDateTime zonedDateTimeOfRegion = ZonedDateTime.of(2014, 3, 9, 1, 59, 0, 0, ZoneId.of("America/Los_Angeles"));
        System.out.println("zonedDateTimeOfRegion = "+zonedDateTimeOfRegion);
	}


}
