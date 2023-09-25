package Model;

import java.util.Date;

public class NoteModel {
 private int nid;
 private String ntitle;
 private String desc;
 private Date date;
 private int cid;
 private int uid;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getNid() {
	return nid;
}
public void setNid(int nid) {
	this.nid = nid;
}
public String getNtitle() {
	return ntitle;
}
public void setNtitle(String ntitle) {
	this.ntitle = ntitle;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public Date getDate() {
	return date;
}
public void setDate(java.util.Date date2) {
	this.date =  date2;
}
 
}
