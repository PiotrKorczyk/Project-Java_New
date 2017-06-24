package DecorateTheView;

public abstract class ViewDecorator implements InterfaceView{
	protected InterfaceView dekorowanyWidok;
	
	public ViewDecorator(InterfaceView dekorowanyWidok){
		this.dekorowanyWidok = dekorowanyWidok;
	}
	
}
