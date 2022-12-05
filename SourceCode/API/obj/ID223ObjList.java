package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID223ObjList {
	
	@XmlElement(name = "data")
    private List<ID223Obj> id223ObjLst = new ArrayList<>();
	
	public List<ID223Obj> getId223ObjLst() {
		return id223ObjLst;
	}
	
	public void setId223ObjLst(List<ID223Obj> id223ObjLst) {
		this.id223ObjLst = id223ObjLst;
	}

}
