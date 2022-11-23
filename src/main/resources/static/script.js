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
            <p class="task__desc">{{data.desc}}</p>
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
            desc:''
        },
        tasks:[
            {
                title: 'some task',
                desc:'some desc'
            },
            {
                title:'some other task',
                desc:'some other desc'
            }
        ]
    },
    methods: {
        delete_task(id){
            this.tasks.splice(id,1);
        },
        add_task(){
            if(this.new_task.title!=''){
                this.tasks.push({
                    title:this.new_task.title,
                    desc:this.new_task.desc
                });
            this.new_task.title='';
            this.new_task.desc='';
            }
        }
    },
});
