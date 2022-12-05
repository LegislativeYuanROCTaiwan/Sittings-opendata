package API.obj;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "opendata")
public class ID148ObjList {

	@XmlElement(name = "data")
	private List<ID148Obj> id148ObjLst = new ArrayList<>();

	public List<ID148Obj> getId148ObjLst() {
		return id148ObjLst;
	}

	public void setId148ObjLst(List<ID148Obj> id148ObjLst) {
		this.id148ObjLst = id148ObjLst;
	}

}
