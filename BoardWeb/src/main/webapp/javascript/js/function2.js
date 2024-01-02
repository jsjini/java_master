// function2.js
let members = `[{"id":1,"first_name":"Doris","last_name":"Sigge","email":"dsigge0@blogspot.com","gender":"Female","salary":4740},
{"id":2,"first_name":"Mab","last_name":"Goning","email":"mgoning1@plala.or.jp","gender":"Female","salary":1553},
{"id":3,"first_name":"Gerta","last_name":"Schoroder","email":"gschoroder2@wisc.edu","gender":"Female","salary":8452},
{"id":4,"first_name":"Celle","last_name":"Stace","email":"cstace3@answers.com","gender":"Female","salary":2713},
{"id":5,"first_name":"Manny","last_name":"Wollacott","email":"mwollacott4@nasa.gov","gender":"Male","salary":3849},
{"id":6,"first_name":"Brandtr","last_name":"Algy","email":"balgy5@wikimedia.org","gender":"Male","salary":5594},
{"id":7,"first_name":"Estele","last_name":"Lias","email":"elias6@acquirethisname.com","gender":"Female","salary":9886},
{"id":8,"first_name":"Marika","last_name":"De Carteret","email":"mdecarteret7@storify.com","gender":"Female","salary":4635},
{"id":9,"first_name":"Shara","last_name":"O'Donnell","email":"sodonnell8@nba.com","gender":"Female","salary":9957},
{"id":10,"first_name":"Ezechiel","last_name":"Bartolomeu","email":"ebartolomeu9@ed.gov","gender":"Male","salary":5651},
{"id":11,"first_name":"Holt","last_name":"Govenlock","email":"hgovenlocka@sun.com","gender":"Male","salary":1598},
{"id":12,"first_name":"Deck","last_name":"Shard","email":"dshardb@squarespace.com","gender":"Male","salary":8008},
{"id":13,"first_name":"Elisha","last_name":"Hamlett","email":"ehamlettc@webs.com","gender":"Male","salary":8870},
{"id":14,"first_name":"Thornton","last_name":"Smaling","email":"tsmalingd@gov.uk","gender":"Male","salary":1988},
{"id":15,"first_name":"Novelia","last_name":"Dillow","email":"ndillowe@moonfruit.com","gender":"Female","salary":7995}]`;

let memberAry = JSON.parse(members); // 문자열 -> 객체변환
console.log(memberAry);

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여'];

function makeHeader(fields = [], pos = {}) {
    let tr = document.createElement('tr');
    fields.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
    tr.setAttribute('style','background-color: #ccc')
}

makeHeader(titles, document.getElementById('theader'));

function makeBody(data = [], post = {}) {
    data.forEach(function (mems) {
        let tr = document.createElement('tr');
        for (mem in mems) {
            let td = document.createElement('td');
            td.innerText = mems[mem];
            tr.appendChild(td);
        }
        post.appendChild(tr);
        if (mems.gender == 'Male') {
            tr.setAttribute('style', 'background-color: aqua');
        } else {
            tr.setAttribute('style', 'background-color: pink');
        }
    })
}

makeBody(memberAry, document.getElementById('tbody'));
