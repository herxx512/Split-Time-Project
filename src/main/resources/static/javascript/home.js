//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//DOM Elements
const submitForm = document.getElementById("split-form")
const splitContainer = document.getElementById("split-container")

//Modal Elements
let splitDay = document.getElementById(`modal-day`)
let splitExerciseName = document.getElementById(`modal-exerciseName`)
let splitSets = document.getElementById(`modal-sets`)
let splitRepititions = document.getElementById(`modal-repititions`)
let splitType = document.getElementById(`modal-type`)
let updateSplitBtn = document.getElementById('update-split-button')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/fitness/workout-splits/"

//Logout Method
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

//Submit New Splits
const handleSubmit = async (e) => {
    e.preventDefault()
    let bodyObj = {
        day: document.getElementById("day").value,
        exerciseName: document.getElementById("exerciseName").value,
        sets: document.getElementById("sets").value,
        repititions: document.getElementById("repititions").value,
        type: document.getElementById("type").value
    }
    await addSplit(bodyObj);
    document.getElementById("day").value = ''
    document.getElementById("exerciseName").value = ''
    document.getElementById("sets").value = ''
    document.getElementById("repititions").value = ''
    document.getElementById("type").value = ''
}

async function addSplit(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getSplits(userId);
    }
}

//Retrieve all workout-splits associated with user
async function getSplits(userId) {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createSplitCards(data))
        .catch(err => console.error(err))
}

//Update split and Get split by splitId
async function getSplitById(splitId){
    await fetch(baseUrl + splitId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))
        .catch(err => console.error(err.message))
}

async function handleSplitEdit(splitId){
    let bodyObj = {
        id: splitId,
        day: splitDay.value,
        exerciseName: splitExerciseName.value,
        sets: splitSets.value,
        repititions: splitRepititions.value,
        type: splitType.value
    }

    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getSplits(userId);
}

//Delete split
async function handleDelete(splitId){
    await fetch(baseUrl + splitId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getSplits(userId);
}

//Helper function that creates a card for each item and appends it to the split container
const createSplitCards = (array) => {
    splitContainer.innerHTML = ''
    array.forEach(obj => {
        let splitCard = document.createElement("div")
        splitCard.classList.add("card")
        splitCard.innerHTML = `
            <div class="card-inside">
                <div class="card-body">

                    <p class="card-text">Day: ${obj.day}</p>
                    <p class="card-text">Exercise Name: ${obj.exerciseName}</p>
                    <p class="card-text">Sets: ${obj.sets} x Reps: ${obj.repititions}</p>
                    <p class="card-text">Type: ${obj.type}</p>

                    <div class="de-btns">

                        <button class="delete-btn" onclick="handleDelete(${obj.id})">Delete</button>

                        <button onclick="getSplitById(${obj.id})" type="button" class="edit-btn"
                        data-bs-toggle="modal" data-bs-target="#split-edit-modal">
                        Edit
                        </button>

                    </div>
                </div>
            </div>
        `
        splitContainer.append(splitCard);
    })
}

//Populate fields
const populateModal = (obj) =>{
    splitDay.innerText = ''
    splitDay.innerText = obj.day

    splitExerciseName.innerText = ''
    splitExerciseName.innerText = obj.exerciseName

    splitSets.innerText = ''
    splitSets.innerText = obj.sets

    splitRepititions.innerText = ''
    splitRepititions.innerText = obj.repititions

    splitType.innerText = ''
    splitType.innerText = obj.type

    updateSplitBtn.setAttribute('data-split-id', obj.id)
}

//Get splits method, Submit method, and Update method
getSplits(userId);

submitForm.addEventListener("submit", handleSubmit)

updateSplitBtn.addEventListener("click", (e)=>{
    let splitId = e.target.getAttribute('data-split-id')
    handleSplitEdit(splitId);
})

// Changing NavBar
function changeBar(){
    let bar = document.getElementById("nav");
    let home = document.getElementById("home");
    let logoutBtn = document.getElementById("logoutBtn");

    let scrollValue = window.scrollY;

    if(scrollValue < 650){
        bar.classList.remove('barColor2')
        bar.classList.add('barColor1')
        home.classList.add('active1')
        home.classList.remove('active2')
        logoutBtn.classList.add('logout-btn1')
        logoutBtn.classList.remove('logout-btn2')
    } else {
        bar.classList.add('barColor2')
        bar.classList.remove('barColor1')
        home.classList.remove('active1')
        home.classList.add('active2')
        logoutBtn.classList.remove('logout-btn1')
        logoutBtn.classList.add('logout-btn2')
    }
}

window.addEventListener('scroll',changeBar);