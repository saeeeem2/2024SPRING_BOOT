console.log("boardRegister");

document.getElementById('trigger').addEventListener('click',()=>{
	document.getElementById('files').click();
});

const regExp=new RegExp("\.(exe|sh|bat|js|dll|msi)$");//실행파일 막기
const regExpImg=new RegExp("\.(jpg|jpeg|png|bmp|gif)$");
const maxSize=1024*1024*20;

function fileValidation(fileName,fileSize){
	if(regExp.test(fileName)){
		return 0;
	}else if(fileSize>maxSize){
		return 0;
	}else{
		return 1;
	}
};

document.addEventListener('change',(e)=>{
	if(e.target.id=='files'){
		const fileObject=document.getElementById('files').files;//multiple배열로 들어옴
		console.log(fileObject);
		document.getElementById('regBtn').disabled=false;
		
		const div=document.getElementById('fileZone');
		
		//이전에 업로드 했던 파일들이 있다면 제거
		div.innerHTML="";
		let ul=`<ul class="list-group list-group-flush">`;
		
		let isOK=1; //여러 파일에 대한 값 확엔에 대한 값
		for(let file of fileObject){
			let vaildResult=fileValidation(file.name,file.size);
			isOK*=vaildResult; //하나 씩 모든 파일에 대한 확인
			ul+=`<li class="list-group-item">`;
			ul+=`<div class="ms-2 me-auto">`;
			ul+=`${vaildResult ? '<div class="fw-bold"> 업로드 가능' : '<div class="fw-bold text-danger">업로드 불가능'}</div.`;
			ul+=`${file.name}</div>`;
			ul+=`<span class="badge bg-${vaildResult ? 'success':'danger'} rounded-pill">${file.size}Byte</span>`;
		}
		
		ul+=`</ul>`;
		div.innerHTML=ul;
		
		if(isOK==0){
			//파일 중 valild결과에 맞지 않는 값이 있다는 결과
			document.getElementById('regBtn').disabled=true;
		}
	}
})