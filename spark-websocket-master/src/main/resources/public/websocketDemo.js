//Establish the WebSocket connection and set up event handlers

//OD STRONY KLIENTA
var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port+ "/public/");
webSocket.onmessage = function (msg) { paint(msg); };
webSocket.onclose = function () { alert("WebSocket connection closed") };
var Mode=1;

id("enterWindow").addEventListener("keypress", function (e) {
    if (e.keyCode === 13) {
        var message = String.fromCharCode(1)+e.target.value;
        if (message !== "") {
            webSocket.send(message); //wysyłamy do servera name i czekamy na listę kanałów od serwera
            screenMode(2);
        }
    }
});

id("newCanal").addEventListener("click", function () {
    webSocket.send(String.fromCharCode(2));
});

//Send message if enter is pressed in the input field
id("message").addEventListener("keypress", function (e) {
    if (e.keyCode === 13) { sendMessage(e.target.value); }
});

id("leaveCanal").addEventListener("click", function () {
    screenMode(2);
    webSocket.send(String.fromCharCode(4));
});

//Send message if "Send" is clicked
id("send").addEventListener("click", function () {
    sendMessage(String.fromCharCode(5)+id("message").value);
});

id("chooseChatbot").addEventListener("click", function () {
    screenMode(4);
    webSocket.send(String.fromCharCode(6));
});

id("leaveChatbot").addEventListener("click", function () {
    screenMode(2);
    webSocket.send(String.fromCharCode(7));
});

id("time").addEventListener("click", function () {
    webSocket.send(String.fromCharCode(6) + "time");
});

id("weekday").addEventListener("click", function () {
    webSocket.send(String.fromCharCode(6) + "weekday");
});

id("weather").addEventListener("click", function () {
    webSocket.send(String.fromCharCode(6) + "weather");
});


function screenMode(mode)
{
    Mode = mode;

    switch(mode){
        case 1:
            id("getName").style.display = '';
            id("canals").style.display = 'none';
            id("canal").style.display = 'none';
            id("chatbot").style.display = 'none';
            break;
        case 2:
            id("getName").style.display = 'none';
            id("canals").style.display = '';
            id("canal").style.display = 'none';
            id("chatbot").style.display = 'none';
            break;
        case 3:
            id("getName").style.display = 'none';
            id("canals").style.display = 'none';
            id("canal").style.display = '';
            id("chatbot").style.display = 'none';
            break;
        case 4:
            id("getName").style.display = 'none';
            id("canals").style.display = 'none';
            id("canal").style.display = 'none';
            id("chatbot").style.display = '';
    }
}

function paint(msg) {
    var data = JSON.parse(msg.data);
    //insert("chat", data.userMessage);
    var canalList1 = data.canalList;
    var sender = data.sender;
    var message = data.message;
    //alert("Canal List=" + canalList1);
    switch(Mode){
        case 1:
            break;
        case 2:
            displayCanalList(canalList1);
            break;
        case 3:
            updateChat(sender,message);
            break;
        case 4:
            updateChatbot(sender,message);
            break;
    }
    //data.userlist.forEach(function (user) {
    //    insert("userlist", "<li>" + user + "</li>");
}

function getCookieValue(a) {
    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
    return b ? b.pop() : '';
}

//Send a message if it's not empty, then clear the input field
function sendMessage(message) {
    if (message !== "") {
        webSocket.send(message);
        id("message").value = "";
    }
}

//Update the chat-panel, and the list of connected users
function updateChat(sender,msg) {
    addChatMsg(sender,msg);
    // insert("chat", msg);
    //id("userlist").innerHTML = "";
    //data.userlist.forEach(function (user) {
    //    insert("userlist", "<li>" + user + "</li>");
    //});
}

function updateChatbot(sender,msg) {
    id("responseTime").style.display = 'none';
    id("responseWeekday").style.display = 'none';
    id("responseWeather").style.display = 'none';

    var Id=null;
    switch (sender)
    {
        case "time":
            id("responseTime").style.display = '';
            id("responseTime").textContent = msg;
            break;
        case "weekday":
            id("responseWeekday").style.display = '';
            id("responseWeekday").textContent = msg;
            break;
        case "weather":
            id("responseWeather").style.display = '';
            id("responseWeather").textContent = msg;
            break;
    }
}


function chooseCanal(nr)
{
    webSocket.send(String.fromCharCode(3)+nr);
    id("canalNumber").textContent = "Chat number: "+ nr;
    id("chat").textContent="";
    screenMode(3);
}

function displayCanalList(canalList1)
{
    if(canalList1!="")
    {
        var tab = canalList1.split(",");
        var h="";
        for(i=0;i<tab.length;i++)
        {
            h+="<p align = \"left\"><button align = \"left\" onclick = \"chooseCanal("+tab[i]+")\" id = \"Canal"+tab[i] +"\"> Chat "+tab[i]+" </button></p>";
            h+="<BR>";
        }
        id("canalList").innerHTML = h;
    }
}

//Helper functions for inserting HTML as the first child of an element
function insert(targetId, message) {
    id(targetId).insertAdjacentHTML("beforeend", message);
}
function addChatMsg(user, message) {
    var msg = "<span>User "+user+" send:<BR> "+message+"</span><BR><hr>";
    id("chat").insertAdjacentHTML("afterbegin", msg);
}
//Helper function for selecting element by id
function id(id) {
    return document.getElementById(id);
}