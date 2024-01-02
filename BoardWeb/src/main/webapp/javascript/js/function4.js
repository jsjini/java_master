// function4.js

// 달력을 생성하는 객체
const cal = {
    days: ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'],
    makeCalendar: function (month) {
        this.makeTitle(this.days, document.getElementById('theader'));
        this.makeBody(month, document.getElementById('tbody'));
    },
    makeTitle: function (fields, pos) {
        let tr = document.createElement('tr');
        fields.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    },
    makeBody: function (month, pos) {
        let tr = document.createElement('tr');
        // 공백
        let firstDay = this.getFirstDay(month);
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        }
        // 날짜
        let lastDate = this.getLastDate(month);
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
    },
    getFirstDay(month) {
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
    },
    getLastDate(month) {
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
}
cal.makeCalendar(1);