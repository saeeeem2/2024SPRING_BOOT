console.log(`board comment`);

document.getElementById(`cmtPostBtn`).addEventListener(`click`, ()=>{
    const cmtText = document.getElementById(`cmtText`);
    if(cmtText.value == null || cmtText.value ==``){
        alert(`댓글을 입력하세요`);
        cmtText.focus();
        return false;
    }else{
        let cmtData={
            bno:bnoVal,
            writer:document.getElementById(`cmtWriter`).innerText,
            content:cmtText.value
        };
        console.log(cmtData);
        postCommentToServer(cmtData).then(result =>{
            if(result==`1`){
                alert(`댓글 등록 성공`);
                cmtText.value=``;
            }
            //화면에 뿌리기
            spreadCommentList(bnoVal);
        })
    }

})

async function postCommentToServer(cmtData){
    try {
        const url = `/comment/post`;
        const config ={
            method:`post`,
            headers:{
                'content-type':`application/json; charset=utf-8`
            },
            body:JSON.stringify(cmtData)
        };
        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

async function getCommentListFromServer(bno,page){
    try {
        const resp = await fetch("/comment/"+bno+'/'+page);
        const result = await resp.json();
        return result;
    } catch (error) {
        console.log(error);
    }
}


function spreadCommentList(bno,page=1){
    getCommentListFromServer(bno,page).then(result=>{
        console.log(result);
        //댓글 뿌리기
        const ul = document.getElementById(`cmtListArea`);
        if(result.length>0){
			if(page==1){ //1페이지에서만 댓글 내용 지우기
            ul.innerHTML=``;
			}
            for(let cvo of result){
                let li = `<li class="list-group-item" data-cno="${cvo.cno}" data-writer="${cvo.writer}">`;
                li += `<div class="mb-3">`;
                li += `<div class="fw-bold"> ${cvo.writer}</div>`;
                li += `${cvo.content}`;
                li += `</div>`;
                li += `<span>${cvo.modAt}</span>`;
                li += `<button type="button" class="btn btn-primary mod ms-1 me-1" data-bs-toggle="modal" data-bs-target="#myModal">수정</button>`;
                li += `<button type="button" class="btn btn-primary del">X</button>`;
                li += `</li>`;
                ul.innerHTML += li;
            }
            let moreBtn = document.getElementById(`moreBtn`);
            //현재 페이지 번호가 전체 페이지 번호보다 작다면
            //아직 나와야할 페이지가 더 있다면
            console.log(moreBtn);
            //more버튼 표시 조건
            if(result.pgvo.pageNo < result.endPage){
				//숨김속성 해지, 페이지 +1
                moreBtn.style.visibility = `visible`; //표시 
                moreBtn.dataset.page = page+1;
            }else{
                moreBtn.style.visibility = `hidden`;
            }
        }else{
            let li = `<li class="list-group-item">Comment List Empty</li>`;
            ul.innerHTML = li;
        }
    })
}

document.addEventListener('click',(e)=>{
	if(e.target.classList.contains('mod')){
		//수정
		
		//타겟에 가장 가까운 li찾기 : 내 버튼이 포함되어있는 li찾기
		let li=e.target.closest('li');
		//nextSibling : 같은 부모의 다음 형제 객체를 반환
		let cmtText=li.querySelector('.fw-bold').nextSibling;
		console.log(cmtText);
		//nodeBalue : 현재 선택한 노드의 value반환 
		document.getElementById('cmtTextMod').value=cmtText.nodeValue;
		document.getElementById('cmtModBtn').setAttribute('data-cno',li.dataset.cno);
	}else if(e.target.id=='cmtModBtn'){
		let cmtDataMod={
			cno : e.target.dataset.cno,
			content : document.getElementById('cmtTextMod').value
		};
		editCommentToServer(cmtDataMod).then(result=>{
			if(result==='1'){
				alert('수정완료');
				//모달창 닫기
				document.querySelector(".btn-close").click();
			}
		})
	}else if(e.target.classList.contains('del')){
		//삭제
		let li=e.target.closest('li');
		let cnoVal=li.dataset.cno;
		removeCommentToServer(cno).then(result=>{
			if(result==='1'){
				alert('삭제완료');
				spreadCommentList(bnoVal);
			}
		})
		
	} else if(e.target.id=='moreBtn'){
		spreadCommentList(bnoVal,parseInt(e.target.dataset.page));
	}
		
})

async function editCommentToServer(cmtDataMod){
	try{
		const url="/comment/edit";
		const config={
			method:'put',
			headers:{
				'content-type' : 'application./json; charset=utf-8'
			},
			body:JSON.stringify(cmtDataMod)
		};
		const resp=await fetch(url,config);
		const result=await resp.text();
		return result;
		
	}catch(error){
		console.log(error);
	}
}

async function removeCommentToServer(cno){
	try{
	const url="/comment/remove/"+cno;
	const config={
		mothod:'delete',
	};
	const resp=await fetch(url,config);
	const result=await resp.text();
	return rMediaQueryList
	} catch{
		console.log(error);
	}
}