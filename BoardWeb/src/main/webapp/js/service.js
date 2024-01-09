/**
 * service.js
 */
function makeLi(reply = {}) {
	console.log(reply);
	let li = document.createElement('li');
	li.setAttribute('style', 'padding : 3px');
	let span = document.createElement('span');
	span.innerText = '댓글번호: ' + reply.replyNo;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' / 내용: ' + reply.reply;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' / 작성자: ' + reply.name + ' ';
	li.appendChild(span);

	// 삭제버튼
	let btn = document.createElement('button');
	btn.addEventListener('click', async function() {
		// 댓글번호 db 삭제 후 화면에서도 제거
		const promise = await fetch("delReplyJson.do?rno=" + reply.replyNo)
		const json = await promise.json();
		try {
			if (json.retCode == 'OK') {
				alert('삭제됨.');
				// bno, page => 페이지리스트, 페이징리스트 업데이트
				showList(pageInfo);
			} else if (json.retCode == 'NG') {
				alert('처리중 에러.');
			}
		} catch (err) {
			console.error(err);
		}
	})
	btn.innerText = '삭제';
	li.appendChild(btn);
	
	return li;
}