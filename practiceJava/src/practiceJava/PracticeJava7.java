package practiceJava;

public class PracticeJava7 {

	public static void main(String[] args) throws Exception {

		/*
		 * NIO検証(Path取得)
		 *
		 * ファイルアクセスユーティリティ
		 */
//		FileSystem fs = FileSystems.getDefault();
//		Path path1 = fs.getPath("D:/workspace/testWeb/WebContent/index.html");
//
//		Path path2 = Paths.get("D:/workspace/testWeb/WebContent/index.html");
//
//		Path path3 = new File("D:/workspace/testWeb/WebContent/index.html").toPath();
//
//		FileTime ft = null;
//		try{
//			ft = Files.getLastModifiedTime(path1);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("File Name : " + path1.getFileName());
//		System.out.println("Absolute Path : " + path2.toAbsolutePath());
//		System.out.println("URI ; " + path3.toUri());
//		System.out.println("File Update Time : " + ft);


		/*
		 * Fork/Join フレームワーク
		 *
		 * 並列処理で高速化を行う。
		 */
//		List<Integer> cores = Arrays.asList(1,2,4);
//		for(Integer core : cores) {
//			int multiplicity = core; //コア数
//			long start = System.nanoTime();
//			ForkJoinPool pool = new ForkJoinPool(multiplicity);
//			int fibonacci = pool.invoke(new FibonacciTask(40));
//			long end = System.nanoTime();
//			System.out.println("core : " + multiplicity);
//			System.out.println("F(40) = " + fibonacci + " elapsed = " + (end - start));
//			pool.shutdown();
//		}

		/*
		 * try-with-resources
		 *
		 * クローズ処理を記述せずともクローズしてくれる。
		 * 便利。
		 *
		 * ※リソースとして使用するクラスがCloseableクラスを継承しているのを確認のうえ
		 * 　使用すること。
		 */
//		try(ClosableSample sample = new ClosableSample()){
//			System.out.println("リソースを使用した処理");
//			throw new RuntimeException();
//		}


		/*
		 * ダイヤモンド記法
		 *
		 * ジェネリックスの記述省略
		 */
		//java6以前
//		List<String> oldList = new ArrayList<String>();
//
//		List newList = new ArrayList<>();
//
//		oldList.add("a");
//		oldList.add("b");
//		oldList.add("c");
//
//		newList.add("d");
//		newList.add("e");
//		newList.add("f");
//
//		for(String word : oldList) {
//			System.out.println(word);
//		}
//		for(Object word : newList) {
//			System.out.println(word);
//		}

		/*
		 * 例外マルチキャッチ
		 *
		 */
//		try{
//			List l = new ArrayList<>();
//			l.add("e");
//			l.add("w");
////			System.out.println(l.get(3));
//		} catch(NullPointerException | IndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}

		/*
		 * switch分での文字列使用
		 *
		 * ※以下の例だとconditionがnullの場合は
		 * NullPointerExceptionが発生するので注意
		 */
		String condition = "test1";
		switch(condition) {

		case "test" :
			System.out.println(condition + "!");
			break;
		case "test1" :
			System.out.println(condition + "!!");
			break;
		case "test2" :
			System.out.println(condition);
		}


	}

	/**
	 * CloseableSample
	 *
	 * test用AutoCloseable実装クラス
	 * @author Satoken
	 *
	 */
	private static class ClosableSample implements AutoCloseable {
		public void close() throws Exception {
			System.out.println("リソースクローズ");
		}
	}

}
