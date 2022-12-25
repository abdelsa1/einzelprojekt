<script>
import axios from "axios";
import { isAuthenticated, user, jwt_token } from "../store";
    // TODO: Setze hier die URL zu deinem mit Postman erstellten Mock Server
    const api_root = "http://localhost:8080";

    let buch = [];
    let buecher = {
        isbn: null,
        titel: null,
        autor: null,
        kategorie: null,
        buchState: null,
    };

    function getBuchbyState() {
        var config = {
            method: "get",
            url: api_root + "/api/buch",
            headers: {Authorization: "Bearer " + $jwt_token,}

};
        

        axios(config)
            .then(function (response) {
                buch = response.data;
            })
            .catch(function (error) {
                alert("Could not get buch");
                console.log(error);
            });
    }
    getBuchbyState();


    function createBuch() {
        var config = {
            method: "post",
            url: api_root + "/api/buch",
            headers: {Authorization: "Bearer " + $jwt_token,
                "Content-Type": "application/json",
            },
            data: buecher,
        };

        axios(config)
            .then(function (response) {
                alert("Buch created");
                getBuch();
            })
            .catch(function (error) {
                alert("Could not create Buch");
                console.log(error);
            });
    }



</script>



<div class="container mt-3">
<h1 class="mt-3">Buch hinzufügen</h1>
<form class="mb-5">

<div class="col">
            <label class="form-label" for="isbn">ISBN</label>
            <input
                bind:value={buecher.isbn}
                class="form-control"
                id="isbn"
                type="text"
            />
        </div>


    <div class="row mb-3">
        <div class="col">
            <label class="form-label" for="titel">Buchtitel</label>
            <input
                bind:value={buecher.titel}
                class="form-control"
                id="titel"
                type="text"
            />
        </div>
</div>

<div class="row mb-3">
        <div class="col">
            <label class="form-label" for="kurzfassung">Kurzfassung</label>
            <input
                bind:value={buecher.kurzfassung}
                class="form-control"
                id="kurzfassung"
                type="text"
            />
        </div>


        <div class="col">
            <label class="form-label" for="autor">AutorIn</label>
            <input
                bind:value={buecher.autor}
                class="form-control"
                id="autor"
                type="text"
            />
        </div>

    </div>
    <div class="row mb-3">
        <div class="col">
            <label class="form-label" for="kategorie">Buch Kategorie</label>
            <select
                bind:value={buecher.kategorie}
                class="form-select"
                id="kategorie"
                type="text"
            >
                <option value=" ">  </option>
                <option value="Psychologie">Psychologie</option>
                <option value="Recht">Recht</option>
                <option value="Gesundheit">Gesundheit</option>
                <option value="Wirtschaft">Wirtschaft</option>
                <option value="Linguistik">Linguistik</option>
                <option value="Architektur">Architektur</option>
            </select>
        </div>

    </div>
    <button type="button" class="btn btn-primary" on:click={createBuch}>Hinzufügen</button>
</form>

  <h2>Alle Bücher</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" data-bs-toggle="tab" href="#verfuegbar">Verfügbar</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="#reserviert">Reserviert</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-bs-toggle="tab" href="ausgeliehen">Ausgeliehen</a>
    </li>
  </ul>

  <!-- Kachel -->
  <div class="tab-content">
    <div id="verfuegbar" class="container tab-pane active"><br>
      <table class="table">
    <thead>
        <tr>
            <th scope="col">ISBN</th>
            <th scope="col">Buchtitel</th>
            <th scope="col">AutorIn</th>
            <th scope="col">Kategorie</th>
            <th scope="col">Status</th>

        </tr>
    </thead>
    <tbody>
        {#each buch as b}
        {#if b.buchState === 'VERFUEGBAR'}
            <tr>
                <td>{b.isbn}</td>
                <td>{b.titel}</td>
                <td>{b.autor}</td>
                <td>{b.kategorie}</td>
                <td>{b.buchState}</td>
            </tr>
            {/if}
        {/each}
        
    </tbody>
</table>
    </div>
        </div>


  <!-- Kachel -->
    <div id="reserviert" class="container tab-pane fade"><br>
       <table class="table">
    <thead>
        <tr>
            <th scope="col">ISBN</th>
            <th scope="col">Buchtitel</th>
            <th scope="col">AutorIn</th>
            <th scope="col">Kategorie</th>
            <th scope="col">Status</th>

        </tr>
    </thead>
    <tbody>
        {#each buch as b}
             {#if b.buchState === 'RESERVIERT'}
            <tr>
                <td>{b.isbn}</td>
                <td>{b.titel}</td>
                <td>{b.autor}</td>
                <td>{b.kategorie}</td>
                <td>{b.buchState}</td>
            </tr>
            {/if}
        {/each}
    </tbody>
</table>
  </div>

<!-- Kachel -->
    <div id="ausgeliehen" class="container tab-pane fade"><br>
       <table class="table">
    <thead>
        <tr>
            <th scope="col">ISBN</th>
            <th scope="col">Buchtitel</th>
            <th scope="col">AutorIn</th>
            <th scope="col">Kategorie</th>
            <th scope="col">Status</th>

        </tr>
    </thead>
    <tbody>
        {#each buch as b}
             {#if b.buchState === 'AUSGELIEHEN'}
            <tr>
                <td>{b.isbn}</td>
                <td>{b.titel}</td>
                <td>{b.autor}</td>
                <td>{b.kategorie}</td>
                <td>{b.buchState}</td>
            </tr>
            {/if}
        {/each}
    </tbody>
  </div>
    </div>




