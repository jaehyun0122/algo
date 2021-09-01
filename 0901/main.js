text = "";
let images = [];
let sImages = [];

let cnt = 0;
let cnt2 = 0;
let num = 0;
let sNum = 0;

let fds = window.location.search;

function show() {
    console.log(fds);
    for (i = 0; i < 16; i++) {
        if (fds == "?0")
            images[i] = "food/" + (i + 1) + ".jpg";
        else if (fds == "?1")
            images[i] = "ice/" + (i + 1) + ".jpg";
        else if (fds == "?2")
            images[i] = "snack/" + (i + 1) + ".jpg";
    }
    images.sort(function (a, b) { return 0.5 - Math.random() });
    showImg(num);
}

show();

function showImg(num) {
    document.getElementById('image').src = images[num];
    document.getElementById('images').src = images[num + 1];
    cnt2++;

}

function showImgRst(n) {
    if (n == 0) {
        document.getElementById('image').src = images[0];
        document.getElementById('images').style.display = "none";
    }
    else {
        document.getElementById('image').style.display = "none";
        document.getElementById('images').src = images[1];
    }
    let target = document.getElementById("win");
    target.style.display = "inline";
    cnt2++;
}

function change(n) {
    if (cnt2 < 18) {
        cnt++;
        if (n == 0)
            sImages[sNum++] = images[num];
        else
            sImages[sNum++] = images[num + 1];
        num += 2;

        showImg(num);

        if (cnt == images.length / 2) {
            for (i = 0; i < sImages.length; i++) {
                images[i] = sImages[i];
                sImages[i] = null;
            }
            images.splice(cnt);
            cnt = 0;
            num = 0;
            sNum = 0;
            showImg(num);
        }
    }
    else if (cnt2 == 18) {
        showImgRst(n)
    }
}
