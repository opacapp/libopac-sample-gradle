libopac sample
==============

This is a sample how to use libopac in a Gradle project

Usage:

    $ gradlew run

You will receive an output that should look similar to:

    :compileJava
    warning: [options] bootstrap class path not set in conjunction with -source 1.7
    1 warning
    :processResources UP-TO-DATE
    :classes
    :run
    Hello OPAC!
    Obtaining search fields...
    Found a first search field: Freie Suche
    Searching for 'hello' in this field...
    Found 177 matches.
    First match: SearchResult [id= null, type=SCORE_MUSIC, nr=0, innerhtml=<br />[2015]<br />T 1121 A Songbook<br /><b>Vormerkung (1,- Euro)</b>]
    Fetching details for the first result...
    Got details: DetailledItem [details=[Detail [desc=Titel/Stichwort:, content=25], Detail [desc=Verfasser:, content=Adele], Detail [desc=Hrsg./Bearb.:, content=Norey, Jenni], Detail [desc=Titelzusatz:, content=eleven songs arranged for easy piano], Detail [desc=Ausgabe:, content=Songbook], Detail [desc=Verlag:, content=Wise Publications], Detail [desc=Jahr:, content=[2015]], Detail [desc=Umfang:, content=51 Seiten], Detail [desc=ISBN:,content=1-7855-8222-4], Detail [desc=Preis/Einband:, content=EUR 24,95], Detail [desc=Signatur:, content=T 1121 A], Detail [desc=Notation:, content=T 1121], Detail [desc=Interessenkreis:, content=Songbook], Detail [desc=Inhalt:, content=Enthõlt: Hello -- Send my Love (To your new Lover) -- I miss You -- When we were young -- Remedy -- Water under the Bridge -- River Lea -- Love in the Dark -- Million Years ago -- All I ask -- Sweetest Devotion]], copies=[de.geeksfactory.opacclient.objects.Copy@3d680b5a], volumes=[], cover=null, title=25, coverBitmap=null, reservable=true, reservation_info=methodToCall=doVormerkung&katkey=952711969&title=25&author=Adele&context=hitlist, id=952711969, volumesearch=null, mediatype=null]

    BUILD SUCCESSFUL

    Total time: 8.155 secs