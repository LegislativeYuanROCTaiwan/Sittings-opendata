package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID143ObjList {

	@XmlElement(name = "data")
	private List<ID143Obj> id143ObjLst = new ArrayList<>();

	public List<ID143Obj> getId143ObjLst() {
		return id143ObjLst;
	}

	public void setId143ObjLst(List<ID143Obj> id143ObjLst) {
		this.id143ObjLst = id143ObjLst;
	}

}