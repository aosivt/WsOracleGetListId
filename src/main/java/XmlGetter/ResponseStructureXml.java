package XmlGetter;

import Entity.Banks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by oshchepkovayu on 20.12.16.
 */
@XmlRootElement(name="banks")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseStructureXml {

    @XmlElement(name="bank")
    private Banks[] banksList;

    public Banks[] getBanksList() {
        return banksList;
    }

    public void setBanksList(List<Banks> banksList) {
        this.banksList = ((List<Banks>)banksList).toArray(new Banks[banksList.size()]);
    }
}
