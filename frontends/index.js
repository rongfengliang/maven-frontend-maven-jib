import app from "./app"
(async ()=>{
    let info =  await app()
    let contentContainer  = document.getElementById("id2")
    contentContainer.innerHTML=JSON.stringify(info)
})()
