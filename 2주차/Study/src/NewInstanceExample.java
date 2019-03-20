public class NewInstanceExample {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("ReceiveAction");
			//Class clazz = Class.forName("ReceiveAction");
			ReceiveAction action = (ReceiveAction) clazz.newInstance();
			action.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}


