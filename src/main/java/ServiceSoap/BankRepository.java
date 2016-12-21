package ServiceSoap;

import Entity.Banks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oshchepkovayu on 21.12.16.
 */
public class BankRepository {
    private static List<Banks> banks = new ArrayList<Banks>();

    public List<Banks> getListBank()
    {
        banks = UseHiber.getListXml();
        return banks;
    }
}
