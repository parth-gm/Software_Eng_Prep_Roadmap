package hashcode;

public class Engine {

	private long type;
	private String optionalField;
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(obj.getClass()!=this.getClass())
			return false;
		Engine eng = (Engine) obj;
		if(eng.type!=this.type)
			return false;
		if(optionalField==null ) {
			if(eng.optionalField!=null)
				return false;
		}
		else if(!optionalField.equals(eng.optionalField))
			return false;
		return true;
	}
}
