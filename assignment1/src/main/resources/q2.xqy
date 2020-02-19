let $papers :=(doc("dblp-soc-papers-V2.xml")/dblp/*)
return <results>
{
   for $x in $papers
    where $x/author='Jia Zhang' and $x/year=2018
   return $x/title
}
</results>