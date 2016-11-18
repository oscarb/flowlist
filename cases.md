# Scenarios

Different interactions and high-level algorithms 

## First-time user

1. App generates a code `c1`
2. User inputs a phone number `p`
3. App sends a SMS with `c1` to phone number `p`
4. App listens for incoming SMS and reads code `c2` / User enters code `c2` from SMS 
5. App checks if `c1 == c2`, if so the app creates and signs in a user

### Creating and signing in user
1. App generates a unique ID for the user `uId`
2. App generates a random password `pwd`
3. A user is stored in the back-end `uId`, `pwd` and with the users phone number hashed `telHash`


## Sharing a link
1. While reading/watching/listening to a link, User clicks the share action in Android and chooses Flowlist among the apps
2. For each contact in the users phone book, the phone number is hashed `contactHash`
3. App checks if there is any contact in the back-end with `contactHash` 
4. Contacts that are also in the back-end are displayed to the user in a list.
5. User selects which contacts to share link with
6. User toggles tags _Read_, _Listen_ and _Watch_.
7. User clicks a button to share the link `link`.

### On the back-end
1. `link` is normalized and then saved/updated in the database
2. Information about the share is stored (the sharing and recieving users)
3. Push notifications are sent to recieving users


## Viewing the list
1. User starts FlowList
2. App syncs local data with backend-data
3. App displays all links that are shared with the user and not archived by the user
