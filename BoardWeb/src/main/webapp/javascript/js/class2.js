// class2.js
let year = 2024;
let month = 2;

let today = new Date(year, month - 1, 1); // {}, new Object()
today = new Date(year, month, 0); // {}, new Object()
console.log(today.getDate(), today.getDay());

class Calendar {
    constructor(year, month) {
        this.year = year;
        this.month = month;
    }
    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
    makeCalendar() {
        console.log('달력생성');
        this.makeTitle(document.getElementById('theader'));
        this.makeBody(document.getElementById('tbody'));
    }
    getLastDate() {
        return new Date(this.year, this.month, 0).getDate();
    }
    getFirstDay() {
        return new Date(this.year, this.month - 1, 1).getDay();
    }
    makeTitle(pos) {
        let tr = document.createElement('tr');
        this.days.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }
    makeBody(pos) {
        let tr = document.createElement('tr');
        let firstDay = this.getFirstDay();
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        }
        let lastDate = this.getLastDate();
        for (let i = 1; i <= lastDate; i++) {
            let td = document.createElement('td');
            td.innerText = i;
            tr.appendChild(td);

            if ((firstDay + i) % 7 == 0) {
                pos.appendChild(tr);
                tr = document.createElement('tr');
            }
            if ((firstDay + i) % 7 == 1) {
                td.setAttribute('style', 'background-color: pink');
            } else if ((firstDay + i) % 7 == 0) {
                td.setAttribute('style', 'background-color: aqua');
            }
        }
        pos.appendChild(tr);
    }
}
const cal = new Calendar(year, month);
cal.makeCalendar();
