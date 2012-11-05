package GameAsteroids;

public interface Selectable {

	public boolean contains(int x, int y);
	public void setSelected(boolean newVal);
	public boolean isSelected();
	
	
}
