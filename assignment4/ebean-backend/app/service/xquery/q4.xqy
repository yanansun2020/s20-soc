let $papers :=(doc("dblp-soc-papers-V1.xml")/dblp/*)
return <results>
{
   for $x in $papers
    where $x/title='Performance Impact of Web Service Migration in Embedded Environments.'
   return $x/*
}
</results>