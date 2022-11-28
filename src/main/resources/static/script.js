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
       return data.tasks;
     } else {
       alert('error', response.status);
     }
}

Vue.component("task", {
    props:["data"],
    methods:{
        task_done(){
            this.$emit("task_done", this.data);

        }
    },
    template:`
    <div class="task">
        <div>
            <h3 class="task__title">{{data.title}}</h3>
            <p class="task__desc">{{data.description}}</p>
        </div>
        <button @click="task_done()" class="task__done">✅</button>
    </div>
    `
});

var vue  = new Vue({
    el:'#app',
    data: {
        new_task: {
            title:'',
            description:''
        },
        tasks:[
            {
                title: 'some task',
                description:'some desc'
            },
            {
                title:'some other task',
                description:'some other desc'
            }
        ]
    },
    mounted() {
        let promise = getList();
        promise.then((tasks) => {
            this.tasks = tasks
        });
    },
    methods: {
        methods: {
            inputChangeHandler(event){
                this.new_task = event.target.value 
            },
            delete_task(id){
            this.tasks.splice(id,1);
            },
            add_task(){
            if(this.new_task.title!=''){
                fetch("http://localhost:8080/tasks",
                {
                    methods: 'POST',
                        headers: {
                      'Content-Type': 'application/json'
                    },
                    body:JSON.stringify({id:createUUID(),title: this.new_task.title, description: this.new_task.description})
                })
                .then((response) => {
                    this.new_task.title='';
                    this.new_task.description='';
                    console.log(response);
                    let promise = getList();
                    promise.then((tasks) => {
                        this.tasks = tasks
                    });
                  });
            }
        }
    },
});
