
import Home from "./pages/Home.svelte";
import StudBuch from "./pages/StudBuch.svelte";
import Studierende from "./pages/Studierende.svelte";
import Buecheruebersicht from "./pages/Buecheruebersicht.svelte";
import Account  from "./pages/Account.svelte";


export default {
    '/': Home,
    '/home': Home,
    '/studbuch': StudBuch,
    '/studierende': Studierende,
    '/buecheruebersicht': Buecheruebersicht,
    '/account' : Account,

}