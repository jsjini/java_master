// table.js
// table 생성 start
let table = document.createElement('table');
table.setAttribute('border', 1); // setAttribute(속성, 값);
table.setAttribute('id', 'list');
table.appendChild(makeHead());
table.appendChild(makeBody());
document.querySelector('body').appendChild(table);
// table 생성 end

// 추가 버튼 클릭 이벤트
document.getElementById('addBtn').addEventListener('click', function() {
    let id = document.getElementById('uid').value;
    let name = document.getElementById('uname').value;
    let phone = document.getElementById('uphone').value;

    if(!id || !name || !phone){
        alert('값을 입력하세요');
        return;
    }
    
    let friend = {id, name, phone}; // 키랑 값이 이름이 같으면 하나만 적어도됨.
    document.querySelector('#list>tbody').appendChild(makeTr(friend));

    document.getElementById('uid').value = '';
    document.getElementById('uname').value = '';
    document.getElementById('uphone').value = '';
    document.getElementById('uid').focus();
});

// 변경 버튼 클릭 이벤트
document.getElementById('editBtn').addEventListener('click', function() {
    // 찾을 값
    let findId = document.getElementById('uid').value;
    // 변경 할 대상
    let phone = document.getElementById('uphone').value;
    // 찾을 대상
    let target = document.querySelectorAll('#list>tbody>tr');
    // console.log(target);
    target.forEach(function(item, idx, ary){   // forEach() 함수가 매개값으로 온다.
    //    console.log(item, idx, ary); 
        let tr = item;
        if(tr.children[0].innerText == findId){
            tr.children[2].innerText = phone;
        }
    });
});

// 선택삭제 버튼 클릭 이벤트
document.getElementById('delBtn').addEventListener('click', function(){
    document.querySelectorAll('#list>tbody>tr>td>input:checked').forEach(function(item){
        item.parentElement.parentElement.remove();
    })
});

function makeHead(){
    // thead 생성
    let thead = document.createElement('thead');
    // tr 생성
    let tr = document.createElement('tr');
    // th*3 생성
    for(let prop in obj1) {
        let th = document.createElement('th');
        th.innerText = prop.toUpperCase();
        tr.appendChild(th);
    }
    // 삭제
    let th = document.createElement('th');
    th.innerText = '삭제';
    tr.appendChild(th);
    let th1 = document.createElement('th');
    th1.innerText = '선택삭제';
    tr.appendChild(th1);
    thead.appendChild(tr);
    return thead;
};

function makeBody(){
    // tbody 생성
    let tbody = document.createElement('tbody');

    for(let friend of friends){
        tbody.appendChild(makeTr(friend));
    }
    return tbody;
};

function makeTr(friend={}) {
    // <tr><td>user1</td><td>홍길동</td><td>010-1111</td></tr>
    let tr1 = document.createElement('tr');
    tr1.addEventListener('click', function(){
        document.getElementById('uid').value = this.children[0].innerText
        document.querySelector('#uname').value = this.children[1].innerText
        document.getElementById('uphone').value = this.children[2].innerText
    })
    for(let prop in friend) {
        let td = document.createElement('td');
        td.innerText = friend[prop];
        tr1.appendChild(td);
    }
    // 삭제버튼 생성
    let td = document.createElement('td');
    let btn = document.createElement('button');
    // button 이벤트 등록
    btn.addEventListener('click', function(e) { // 이벤트핸들러
        e.stopPropagation(); // 상위요소로 이벤트 전파 차단
        this.parentElement.parentElement.remove(); //this - 현재요소 / parentElement - 상위요소
    });
    btn.innerText = '삭제';
    td.appendChild(btn);
    tr1.appendChild(td);

    // 체크박스 생성
    let td1 = document.createElement('td');
    td1.setAttribute('align', 'center');
    let check = document.createElement('input');
    
    td1.addEventListener('click', function(e){
        e.stopPropagation(); // 상위요소로 이벤트 전파 차단
        // console.log(e);
    });
    check.setAttribute('type', 'checkbox');
    td1.appendChild(check);
    tr1.appendChild(td1);
    return tr1;
}