package practiceJava;

public interface DefaultMethodInterface {
	public default String getName(){
		return "デフォルト";
	}
}
