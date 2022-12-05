package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID221ObjList {
	
	@XmlElement(name = "data")
    private List<ID221Obj> id221ObjLst = new ArrayList<>();
	
	public List<ID221Obj> getId221ObjLst() {
		return id221ObjLst;
	}
	
	public void setId221ObjLst(List<ID221Obj> id221ObjLst) {
		this.id221ObjLst = id221ObjLst;
	}

}
