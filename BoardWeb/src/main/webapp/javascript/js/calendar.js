// calendar.js
let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']

// let lastDate = getLastDate(2);
// let firstDay = getFirstDay(2);
// console.log(lastDate, firstDay);

// 달력생성
function makeCalendar(month) {
    makeTitle(days, document.getElementById('theader'));
    makeBody(month, document.getElementById('tbody'));
}
makeCalendar(3);

function getLastDate(month) {
    // 월입력 => 마지막날을 반환  31, 29, 31, 30, 31,~~
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12: return 31;
        case 4:
        case 6:
        case 9:
        case 11: return 30;
        case 2: return 29;
    }
}

function getFirstDay(month) {
    // 월입력 => 1월의 위치 (공백이 몇개 반환)
    switch (month) {
        case 1: return 1;
        case 2: return 4;
        case 3: return 5;
        case 4: return 1;
        case 5: return 3;
        case 6: return 5;
        case 7: return 1;
        case 8: return 4;
        case 9: return 0;
        case 10: return 2;
        case 11: return 5;
        case 12: return 0;
    }
}

// header 생성
function makeTitle(dayAry = [], pos = {}) {
    let tr = document.createElement('tr');
    dayAry.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
    tr.setAttribute('style', 'background-color: #ccc')
}

// 날짜 생성
function makeBody(month = 1, pos = {}) {
    let tr = document.createElement('tr');
    // 공백
    let firstDay = getFirstDay(month);
    for (let i = 0; i < firstDay; i++) {
        let td = document.createElement('td');
        td.innerText = "";
        tr.appendChild(td);
    }
    // 날짜
    let lastDate = getLastDate(month);
    for (let i = 1; i <= lastDate; i++) {
        // 토욜: pink, 일욜: aqua
        let td = document.createElement('td');
        td.innerText = i;
        tr.appendChild(td);

        if ((firstDay + i) % 7 == 0) {
            pos.appendChild(tr);
            tr = document.createElement('tr');
        }
        if ((firstDay + i) % 7 == 0) {
            td.setAttribute('style', 'background-color: pink');
        } else if ((firstDay + i) % 7 == 1) {
            td.setAttribute('style', 'background-color: aqua');
        }
    }
    pos.appendChild(tr);
}