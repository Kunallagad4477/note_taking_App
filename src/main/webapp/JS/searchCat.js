function searchCategory(str)
{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
	if(this.readyState==4 && this.status==200){
		document.getElementById("d").innerHTML=this.responseText;
	}
	}
	xhttp.open("GET","SearchCat?catName="+str,true);
	xhttp.send();
}

function searchNotes(cid,uid)
{
	
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(this.readyState==4 && this.status==200){
			document.getElementById("s").innerHTML=this.responseText;
		}
	}
	xhttp.open("GET","SearchNote?cid="+cid+"&uid="+uid+" ");
	xhttp.send();
}