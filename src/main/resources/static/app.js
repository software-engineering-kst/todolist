import {v4 as uuidv4} from 'uuid';
// https://www.uuidgenerator.net/dev-corner/javascript
// по этому методу не получилось генерить

function createUUID() {
  return ([1e7]+-1e3+-4e3+-8e3+-1e11).replace(/[018]/g, c =>
    (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
  );
}

async function getList() {
     let response = await fetch('http://localhost:8080/tasks');
     if (response.ok) {
       let data = await response.json();
       return data.tasks;
     } else {
       alert('error', response.status);
     }
}

//async function updateTask(fetch) {
//    fetch.then((response) => {
//          this.inputValue =''
//          console.log(response);
//          let promise = getList();
//          promise.then((tasks) => {
//              this.notes = tasks
//          });
//        });
//}

function updateTask() {
    let promise = getList();
    promise.then((tasks) => {
        this.notes = tasks
        console.log('qwertyuio');
    });
}

const App = {
    data() {
        return {
            title: 'Список задач',
            placeholderString: 'Введите название задачи',
            inputValue: '',
            notes: []
        }
    },
    mounted() {
        updateTask();
//        let promise = getList();
//        promise.then((tasks) => {
//            this.notes = tasks
//        });
    },
    methods: {
        inputChangeHandler(event){
            this.inputValue = event.target.value 
        },
        addNewNote(){
            if (this.inputValue !== ''){
//                updateTask(fetch("http://localhost:8080/tasks",
//                 {
//                     method: 'POST',
//                     headers: {
//                       'Content-Type': 'application/json'
//                     },
//                     body: JSON.stringify({id: createUUID(), name: this.inputValue})
//                 }))

                fetch("http://localhost:8080/tasks",
                {
                    method: 'POST',
                    headers: {
                      'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({id: uuidv4(), name: this.inputValue})
                })
                  .then((response) => {
                    this.inputValue =''
                    console.log(response);
                    updateTask();
//                    let promise = getList();
//                    promise.then((tasks) => {
//                        this.notes = tasks
//                    });
                  });
            }
        },
        inputKeyPress(event){
            if (event.key === 'Enter') {
                this.addNewNote()
            }
        },
        removeNote(idx){
            fetch("http://localhost:8080/tasks",
            {
                method: 'DELETE',
                headers: {
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify({ id: idx })
            })
              .then((response) => {
                console.log(response);
                let promise = getList();
                promise.then((tasks) => {
                    this.notes = tasks
                });
              });

        }
    }    
}

Vue.createApp(App).mount('#app')
