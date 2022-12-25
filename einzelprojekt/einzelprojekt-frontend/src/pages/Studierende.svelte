<script>
import axios from "axios";
import { isAuthenticated, user, jwt_token } from "../store";

    const api_root = "http://localhost:8080";

    let studierende = [];
    let allestudierende = {
        email: null,
        immatrikulationsnummer: null,
        name: null,
        vorname: null,
    };

    function getStudierende() {
        var config = {
            method: "get",
            url: api_root + "/api/studierende",
            headers: {Authorization: "Bearer " + $jwt_token,}
        };

        axios(config)
            .then(function (response) {
                studierende = response.data;
            })
            .catch(function (error) {
                alert("Could not get studierende");
                console.log(error);
            });
    }
    getStudierende();

    function createStudierende() {
        var config = {
            method: "post",
            url: api_root + "/api/studierende",
            headers: {Authorization: "Bearer " + $jwt_token,
                "Content-Type": "application/json",
            },
            data: allestudierende,
        };

        axios(config)
            .then(function (response) {
                alert("Studierende created");
                getStudierende();
            })
            .catch(function (error) {
                alert("Could not create Studierende");
                console.log(error);
            });
    }
</script>

<h1 class="mt-3">Studierende hinzufügen</h1>
<form class="mb-5">

<div class="col">
            <label class="form-label" for="email">E-Mail</label>
            <input
                bind:value={allestudierende.email}
                class="form-control"
                id="email"
                type="text"
            />
        </div>


    <div class="row mb-3">
        <div class="col">
            <label class="form-label" for="immatrikulationsnummer">Immatrikulationsnummer</label>
            <input
                bind:value={allestudierende.immatrikulationsnummer}
                class="form-control"
                id="immatrikulationsnummer"
                type="text"
            />
        </div>
</div>

<div class="row mb-3">
        <div class="col">
            <label class="form-label" for="name">Name</label>
            <input
                bind:value={allestudierende.name}
                class="form-control"
                id="name"
                type="text"
            />
        </div>


        <div class="col">
            <label class="form-label" for="vorname">Vorname</label>
            <input
                bind:value={allestudierende.vorname}
                class="form-control"
                id="vorname"
                type="text"
            />
        </div>

    </div>
    <button type="button" class="btn btn-primary" on:click={createStudierende}>Hinzufügen</button>
</form>

<h1>Alle Studierende</h1>
<table class="table">
    <thead>
        <tr>
            <th scope="col">E-Mail</th>
            <th scope="col">Immatrikulationsnummer</th>
            <th scope="col">Name</th>
            <th scope="col">Vorname</th>
        </tr>
    </thead>
    <tbody>
        {#each studierende as s}
            <tr>
                <td>{s.email}</td>
                <td>{s.immatrikulationsnummer}</td>
                <td>{s.name}</td>
                <td>{s.vorname}</td>
            </tr>
        {/each}
    </tbody>
</table>
