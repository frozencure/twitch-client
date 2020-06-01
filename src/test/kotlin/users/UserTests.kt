package users

import helix.exceptions.BadRequestException
import helix.extensions.ExtensionsHelixResponse
import helix.users.FollowsHelixResponse
import helix.users.UserHelixResponse
import helix.users.UserService
import helix.users.UsersHelixResponse
import io.ktor.client.statement.request
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.UnstableDefault
import org.junit.Test
import util.HttpClientMockBuilder

@UnstableDefault
class UserTests {

    class `Given GET user is called` {

        private val userResponse = runBlocking<UserHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.SINGLE_USER_WITH_EMAIL))
                .getUser()
        }

        @Test
        fun `then request has no parameters`() =
            assert(userResponse.httpResponse.request.url.toString() == UserService.BASE_URL)


        @Test
        fun `then user is returned`() =
            assert(userResponse.resource != null)


        @Test
        fun `then user has email`() =
            assert(userResponse.resource?.email != null)


    }

    class `Given GET user with login name is called` {

        private val userResponse = runBlocking<UserHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.SINGLE_USER_WITH_EMAIL))
                .getUser("dallas")
        }

        @Test
        fun `then request has login name as parameter`() =
            assert(userResponse.httpResponse.request.url.parameters["login"] != null)


        @Test
        fun `then user is returned`() =
            assert(userResponse.resource != null)


        @Test
        fun `then user has no email`() =
            assert(userResponse.resource?.email != null)
    }

    class `Given GET user with id is called` {
        private val userResponse = runBlocking<UserHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.SINGLE_USER))
                .getUser(44322889)
        }

        @Test
        fun `then request has user id as parameter`() =
            assert(userResponse.httpResponse.request.url.parameters["id"] != null)


        @Test
        fun `then user is returned`() =
            assert(userResponse.resource != null)


        @Test
        fun `then user has no email`() =
            assert(userResponse.resource?.email == null)
    }

    class `Given GET users with no parameters is called` {

        @Test
        fun `then bad request exception is thrown`() {
            runBlocking {
                try {
                    UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.MULTIPLE_USERS))
                        .getUsers()
                } catch (e: Exception) {
                    assert(e is BadRequestException)
                }
            }
        }
    }

    class `Given GET users with login names is called` {
        private val usersResponse = runBlocking<UsersHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.MULTIPLE_USERS))
                .getUsers(loginNames = listOf("dallas", "user_2"))
        }

        @Test
        fun `then request has user login names as parameters`() {
            usersResponse.httpResponse.request.url.parameters.getAll("login")?.let {
                assert(
                    it == listOf("dallas", "user_2")
                )
            }
        }

        @Test
        fun `then users are returned`() =
            assert(usersResponse.resources.size == 2)

    }

    class `Given GET users with pagination is called` {

        val usersResponse = runBlocking<UsersHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.MULTIPLE_USERS_WITH_PAGINATION))
                .getUsers(loginNames = listOf("dallas", "user_2"))
        }


        @Test
        fun `then pagination exists`() = assert(usersResponse.pagination != null)

        class `And next page of users is quried` {

            private val usersResponse = runBlocking {
                UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.MULTIPLE_USERS_WITH_PAGINATION))
                    .getUsers(loginNames = listOf("dallas", "user_2")).nextPage()
            }

            @Test
            fun `then users are returned`() = assert(usersResponse!!.resources.isNotEmpty())

            @Test
            fun `then request has cursor as parameter`() =
                assert(usersResponse!!.httpResponse.request.url.parameters["cursor"] != null)

        }

    }

    class `Given GET users with ids is called` {
        private val usersResponse = runBlocking<UsersHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.MULTIPLE_USERS))
                .getUsers(ids = listOf(44322889, 54232423))
        }

        @Test
        fun `then request has user ids as parameters`() {
            usersResponse.httpResponse.request.url.parameters.getAll("login")?.let {
                assert(
                    it == listOf(44322889, 54232423)
                )
            }
        }

        @Test
        fun `then users are returned`() =
            assert(usersResponse.resources.size == 2)

    }

    class `Given GET user followers with to_user id is called` {
        private val followsResponse = runBlocking<FollowsHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.USER_FOLLOWERS))
                .getUserFollowers(toUserId = 23161357)
        }

        @Test
        fun `then request has to user id as parameters`() {
            followsResponse.httpResponse.request.url.parameters["to_id"]?.let {
                assert(
                    it == 23161357.toString()
                )
            }
        }

        @Test
        fun `then follows are returned`() = assert(followsResponse.resources.isNotEmpty())

        @Test
        fun `then response has pagination`() = assert(followsResponse.pagination != null)

        @Test
        fun `then response has total`() = assert(followsResponse.total != null)

    }

    class `Given GET user followers with from_user id is called` {
        private val followsResponse = runBlocking<FollowsHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.USER_FOLLOWERS))
                .getUserFollowers(fromUserId = 23161357)
        }

        @Test
        fun `then request has to user id as parameters`() {
            followsResponse.httpResponse.request.url.parameters["from_id"]?.let {
                assert(
                    it == 23161357.toString()
                )
            }
        }

        @Test
        fun `then follows are returned`() = assert(followsResponse.resources.isNotEmpty())

        @Test
        fun `then response has pagination`() = assert(followsResponse.pagination != null)

        @Test
        fun `then response has total`() = assert(followsResponse.total != null)

    }

    class `GIVEN GET user followers with no parameters is called` {

        @Test
        fun `then bad request exception is thrown`() {
            runBlocking {
                try {
                    UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.USER_FOLLOWERS))
                        .getUserFollowers()
                } catch (e: Exception) {
                    assert(e is BadRequestException)
                }
            }
        }
    }

    class `Given PUT update user description is called` {
        private val userResponse = runBlocking<UserHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.SINGLE_USER))
                .updateUserDescription("new description")
        }

        @Test
        fun `then request has description as parameter`() =
            assert(userResponse.httpResponse.request.url.parameters["description"] == "new description")


        @Test
        fun `then user is returned`() =
            assert(userResponse.resource != null)
    }

    class `Given GET user extensions is called` {
        private val extensionsResponse = runBlocking<ExtensionsHelixResponse> {
            UserService(HttpClientMockBuilder.withJsonContent(UsersTestData.USER_EXTENSIONS))
                .getUserExtensions()
        }

        @Test
        fun `then extensions are returned`() = assert(extensionsResponse.resources.isNotEmpty())

        @Test
        fun `then request has no parameters`() = assert(
            extensionsResponse.httpResponse.request.url.toString()
                    == UserService.BASE_URL + "/extensions/list"
        )


    }


}