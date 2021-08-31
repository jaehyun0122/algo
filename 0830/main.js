window.onload = function () {
    document.querySelector("#button").addEventListener('click', function () {
        // alert("click");
        let lottoNum = [6];
        let checkNum = [6];
        let bonusNum = 0;
        for (let num = 0; num < 7; num++){
            let randNum = Math.floor(Math.random() * 45 + 1);
            if (num == 6 && checkNum[randNum] != 1) {
                bonusNum = randNum;
            }
            else if (checkNum[randNum] != 1) {
                checkNum[randNum] = 1;
                lottoNum[num] = randNum;
            }
            else if (checkNum[randNum] == 1) {
                num--;
            }
        }
        
        document.querySelector("#mainNum").innerHTML = lottoNum;
        document.querySelector("#subNum").innerHTML = bonusNum;
    });
}
