let writter = '';
let title = '';
let content = '';
let list = '';
let num = 0;
let originContents = localStorage.getItem('contents');
const contentsParse = originContents ? JSON.parse(originContents) : [];
// let list = '<tr>';

        $(document).ready(function () {
            $('#writeButton').click(function () {
            // list += '<td>' + $('#writter').val() + '</td>';
            // list += '<td>' + $('#title').val() + '</td>';
            // list += '<td>' + $('#content').val() + '</td>';
            // list += '<td>' + cnt + '</td>';
            // list += '</tr>';
                writter = $('#writter').val();
                title = $('#title').val();
                content = $('#content').val();
                // console.log(originContents)
            // localStorage.setItem('contents', JSON.stringify([contentsParse, {writter, title, content}]))
                localStorage.setItem('writter', writter);
                localStorage.setItem('title', title);
                localStorage.setItem('content', content);
                localStorage.setItem('num', localStorage.length);
            // localStorage.setItem('writter', $('#writter').val())
            // localStorage.setItem('title', $('#writter').val())
            // localStorage.setItem('content', $('#writter').val())
        })
    });
    
