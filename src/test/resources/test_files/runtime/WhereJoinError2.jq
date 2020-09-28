(:JIQS: ShouldCrash; ErrorCode="RBST0003"; ErrorMetadata="LINE:15:COLUMN:0:" :)
let $stores := parallelize((
  { "storeid" : 1, "state" : "CA" },
  { "storeid" : 2, "state" : "MA" },
  { "storeid" : 3, "state" : "MA" },
  { "storeid" : 4, "state" : "CA" },
  { "storeid" : 5, "state" : "NY" },
  { "storeid" : 6, "state" : "MI" },
  { "storeid" : 7, "state" : "MI" }
))
let $states := parallelize(())
return
for $store in $stores
for $state allowing empty in $states
where $state.code eq $store.state
return { "id" : $store.storeid, "state" : $state.name }


