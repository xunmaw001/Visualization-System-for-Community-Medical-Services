const base = {
    get() {
        return {
            url : "http://localhost:8080/shequyilliaofuwu/",
            name: "shequyilliaofuwu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shequyilliaofuwu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "社区医疗服务可视化系统"
        } 
    }
}
export default base
