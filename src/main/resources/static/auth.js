const signupForm = document.getElementById("signupForm");
const loginForm = document.getElementById("loginForm");

if (signupForm) {
  signupForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const user = {
      name: document.getElementById("signupName").value,
      email: document.getElementById("signupEmail").value,
      password: document.getElementById("signupPassword").value
    };

    const res = await fetch("/auth/signup", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(user)
    });

    const data = await res.json();
    document.getElementById("signupMsg").innerText = data.message || "Signup done";
  });
}

if (loginForm) {
  loginForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const loginData = {
      email: document.getElementById("loginEmail").value,
      password: document.getElementById("loginPassword").value
    };

    const res = await fetch("/auth/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(loginData)
    });

    const data = await res.json();

    if (data.token && !data.token.startsWith("Invalid") && !data.token.startsWith("User")) {
      sessionStorage.setItem("token", data.token);
      document.getElementById("loginMsg").innerText = "Login successful";
      window.location.href = "/";
    } else {
      document.getElementById("loginMsg").innerText = data.token || "Login failed";
    }
  });
}