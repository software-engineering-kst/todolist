function createUUID() {
    // http://www.ietf.org/rfc/rfc4122.txt
    var s = [];
    var hexDigits = "0123456789abcdef";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
    s[8] = s[13] = s[18] = s[23] = "-";

    var uuid = s.join("");
    return uuid;
}

async function getList() {
     let response = await fetch('http://localhost:8080/tasks');
     if (response.ok) {
       let data = await response.json();
       console.log(data);
       return data
     } else {
       alert('error', response.status);
     }
}

const App = {
    data() {
        return { 
            // counter: 0,
            title: 'Список задач',
            placeholderString: 'Введите название задачи',
            inputValue: '',
            notes: getList()
//            ['Заметка 1', 'Заметка 2']
        }
    },
    methods: {
        inputChangeHandler(event){
            this.inputValue = event.target.value 
        },
        addNewNote(){
            if (this.inputValue !== ''){
                fetch("http://localhost:8080/tasks",
                {
                    method: 'POST',
                    headers: {
                      'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({id: createUUID(), name: this.inputValue})
                })
                  .then((response) => {
                    console.log(response);
                  });
                this.inputValue =''
            }
            //getList()
        },
        inputKeyPress(event){
            if (event.key === 'Enter') {
                this.addNewNote()
            }
        },
        removeNote(idx){
            this.notes.splice(idx,1)
        }
    }    
}
 

Vue.createApp(App).mount('#app')
