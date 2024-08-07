let form = document.querySelector("form[name='contact-form']");
let nameInput = document.querySelector("input[name='name']");
let nameInput2 = document.getElementById("form-input-name");
let emailInput = document.querySelector("input[name='email']");
let phoneInput = document.querySelector("input[name='phone']");
let messageInput = document.querySelector("textarea[name='message']");

console.log("nameInput2", nameInput2);
console.log("nameInput", nameInput);

nameInput.isValid = () => !!nameInput.value;
emailInput.isValid = () => isValidEmail(emailInput.value);
phoneInput.isValid = () => isValidPhone(phoneInput.value);
messageInput.isValid = () => !!messageInput.value;

let inputFields = [nameInput, emailInput, phoneInput, messageInput];

let isValidEmail = (email) => {
  let re =
    /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(String(email).toLowerCase());
};

let isValidPhone = (phone) => {
  let re = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
  return re.test(String(phone).toLowerCase());
};

let shouldValidate = false;
let isFormValid = false;

let validateInputs = () => {
  console.log("we are here");
  if (!shouldValidate) return;

  isFormValid = true;
  inputFields.forEach((input) => {
    input.classList.remove("invalid");
    input.nextElementSibling.classList.add("hide");

    if (!input.isValid()) {
      input.classList.add("invalid");
      isFormValid = false;
      input.nextElementSibling.classList.remove("hide");
    }
  });
};

form.addEventListener("submit", (e) => {
  e.preventDefault();
  shouldValidate = true;
  validateInputs();
  if (isFormValid) {
    // TODO: DO AJAX REQUEST
  }
});

inputFields.forEach((input) => input.addEventListener("input", validateInputs));
const backendUrl = 'http://localhost:8090/email'; // Change this to your backend URL

// Fetch all emails and display them
async function fetchEmails() {
  console.log('Fetching emails...');
  try {
    const response = await fetch(backendUrl);
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    const data = await response.json();
    console.log('Emails fetched:', data);
    displayEmails(data);
  } catch (error) {
    console.error('Error fetching emails:', error);
  }
}
