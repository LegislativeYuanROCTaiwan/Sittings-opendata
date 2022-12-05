package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID42ObjList {

	@XmlElement(name = "data")
	private List<ID42Obj> id42ObjLst = new ArrayList<>();

	public List<ID42Obj> getId42ObjLst() {
		return id42ObjLst;
	}

	public void setId42ObjLst(List<ID42Obj> id42ObjLst) {
		this.id42ObjLst = id42ObjLst;
	}

}
