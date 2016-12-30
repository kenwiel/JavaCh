package javach;

import org.json.simple.JSONObject;

public class File {
	//represents a file objects (aka images/webms)
	//and thumbnails
	
	Post post; //parent post 
	JSONObject data;
	/*
	String filename;
	String md5;     //md5 hash
	String url;		//url of file
	String extension;  	//file extension. ex: ".jpg"
	
	int size;  //filesize in bytes
	int width;
	int height;
	
	//thumbnail properties
	int thumbWidth;
	int thumbHeight;
	*/
	public File(Post post){
		this.post = post;
		this.data = post.getData();
	}
	
	public String md5(){ //md5 of the file
	    return (String) data.get("md5");
	}
	public String extension(){ //extension of the file
	    return (String) data.get("ext");
	}
	public int filesize(){
		return (int) (long) data.get("fsize");
	}
	public int width(){
		return (int) (long) data.get("w");
	}
	public int height(){
		return (int) (long) data.get("h");
	}
	public boolean deleted(){ //was the file later deleted?
	    return data.containsKey("filedeleted") && (int) (long) data.get("filedeleted") == 1;
	}
	public String filenameOriginal(){ //original filename 
		return (String) data.get("filename") + extension();
	}
	public String filename(){
		return Long.toString((long)data.get("tim")) + extension();
	}
	
	public String url(){
						//http(s)://i.4cdn.org/board/tim.ext
		return "https://i.4cdn.org/" + post.thread.getBoard() + "/" + data.get("tim") + extension(); //<<placeholder
		
	}
	
	public String thumbName(){
		return Long.toString((long) data.get("tim")) + "s.jpg";
	}
	public String thumbUrl(){ //url of the thumbnail
		return "https://t.4cdn.org/" + post.thread.getBoard() + "/" + data.get("tim") + "s.jpg";
	}

	public int thumbnailWidth(){
		return (int) (long) data.get("tn_w");
	}
	public int thumbnailHeight(){
		return (int) (long) data.get("tn_h");
	}
}
