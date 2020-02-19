let $papers := (doc("dblp-soc-papers-V2.xml")/dblp/*)
return <results>
{
   for $x in $papers
   return $x/title
}
</results>