let $papers :=(doc("dblp-soc-papers-V2.xml")/dblp/*)
for $x in $papers
let $au := $x/author/text()
return $au
