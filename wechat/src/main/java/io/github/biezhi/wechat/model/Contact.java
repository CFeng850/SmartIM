package io.github.biezhi.wechat.model;

import java.util.List;

import cn.ieclipse.smartim.model.impl.AbstractContact;
import cn.ieclipse.util.StringUtils;

public class Contact extends AbstractContact implements Comparable<Contact> {
    
    public static final int CONTACTFLAG_CONTACT = 1;
    public static final int CONTACTFLAG_CHATCONTACT = 2;
    public static final int CONTACTFLAG_CHATROOMCONTACT = 4;
    public static final int CONTACTFLAG_BLACKLISTCONTACT = 8;
    public static final int CONTACTFLAG_DOMAINCONTACT = 16;
    public static final int CONTACTFLAG_HIDECONTACT = 32;
    public static final int CONTACTFLAG_FAVOURCONTACT = 64;
    public static final int CONTACTFLAG_3RDAPPCONTACT = 128;
    public static final int CONTACTFLAG_SNSBLACKLISTCONTACT = 256;
    public static final int CONTACTFLAG_NOTIFYCLOSECONTACT = 512;
    public static final int CONTACTFLAG_TOPCONTACT = 2048;
    
    public long Uin;
    public String UserName;
    public String NickName;
    public String HeadImgUrl;
    
    public int ContactFlag;
    public int MemberCount;
    public String RemarkName;
    public int HideInputBarFlag;
    public int Sex;
    public String Signature;
    public int VerifyFlag;
    public int OwnerUin;
    public String PYInitial;
    public String PYQuanPin;
    public String RemarkPYInitial;
    public String RemarkPYQuanPin;
    public int StarFriend;
    public int AppAccountFlag;
    public int Statues;
    public int AttrStatus;
    public String Province;
    public String City;
    public String Alias;
    public int SnsFlag;
    public int UniFriend;
    public String DisplayName;
    public int ChatRoomId;
    public String KeyWord;
    public String EncryChatRoomId;
    public List<Contact> MemberList;
    
    @Override
    public String getName() {
        if (DisplayName != null && !DisplayName.isEmpty()) {
            return DisplayName;
        }
        
        if (RemarkName != null && !RemarkName.isEmpty()) {
            return RemarkName;
        }
        
        if (NickName != null && !NickName.isEmpty()) {
            return NickName;
        }
        
        return UserName;
    }
    
    @Override
    public String getUin() {
        return UserName;
    }
    
    public Contact getMember(String uid) {
        if (!StringUtils.isEmpty(this.MemberList)) {
            for (Contact t : this.MemberList) {
                if (uid != null && uid.equals(t.UserName)) {
                    return t;
                }
            }
        }
        return null;
    }
    
    @Override
    public int compareTo(Contact that) {
        if (isTop()) {
            return -1;
        }
        int ret = super.compareTo(that);
        
        return ret;
    }
    
    public boolean isTop() {
        return (this.ContactFlag & CONTACTFLAG_TOPCONTACT) != 0;
    }
    
    public String getPYInitial() {
        String py = StringUtils.isEmpty(RemarkPYInitial) ? PYInitial
                : RemarkPYInitial;
        return py;
    }
    
    public boolean match(String input) {
        boolean ret = false;
        if (!StringUtils.isEmpty(PYInitial)) {
            ret = PYInitial.toLowerCase().contains(input);
        }
        if (!ret) {
            if (!StringUtils.isEmpty(PYQuanPin)) {
                ret = PYQuanPin.toLowerCase().contains(input);
            }
        }
        if (!ret) {
            String name = getName().toLowerCase();
            ret = name.contains(input);
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contact) {
            return getUin().equals(((Contact) obj).getUin());
        }
        return super.equals(obj);
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
