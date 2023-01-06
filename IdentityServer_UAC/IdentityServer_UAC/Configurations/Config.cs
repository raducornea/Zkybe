using IdentityServer4.EntityFramework.DbContexts;
using IdentityServer4.EntityFramework.Mappers;
using IdentityServer4.Models;
using IdentityServer4.Test;
using Microsoft.EntityFrameworkCore;
using System.Security.Claims;

namespace IdentityServer_UAC.Configurations
{
    public static class Config
    {
        public static IEnumerable<IdentityResource> IdentityResources =>
           new IdentityResource[]
           {
                new IdentityResources.OpenId()
           };

        public static IEnumerable<ApiScope> ApiScopes =>
            new ApiScope[]
            {
                new ApiScope("openid"),
                new ApiScope("zkybe.admin", "Scope for admin"),
                new ApiScope("zkybe.users", "Scope for users")
            };

        public static IEnumerable<Client> Clients =>
            new Client[]
            {
                new Client
                {
                    ClientId = "zkybe.web",
                    ClientName = "Zkybe Web Client",
                    RequireClientSecret = false,
                    RequirePkce = true,
                    AllowedGrantTypes = GrantTypes.Code,
                    RedirectUris = new[] { "http://localhost:4200", "https://localhost:4200" },
                    PostLogoutRedirectUris = new[] { "http://localhost:4200", "https://localhost:4200" },
                    AllowedScopes = new []
                    {
                        "openid",
                        "zkybe.users",
                        "zkybe.admin"
                    },
                    AllowedCorsOrigins = new[] { "http://localhost:4200", "https://localhost:4200" }
                },

                new Client // TODO: configure redirects and CORS
                {
                    ClientId = "zkybe.mobile",
                    ClientName = "Zkybe Mobile Client",
                    RequireClientSecret = false,
                    RequirePkce = true,
                    AllowedGrantTypes = GrantTypes.Code,
                    RedirectUris = new[] { "" },
                    PostLogoutRedirectUris = new[] { "" },
                    AllowedScopes = new []
                    {
                        "openid",
                        "zkybe.users"
                    },
                    AllowedCorsOrigins = new[] { "" }
                },

                new Client
                {
                    ClientId = "zkybe.test",
                    ClientName = "Zkybe Test Client",
                    ClientSecrets = { new Secret("secret".Sha256()) },
                    RequireClientSecret = true,
                    AllowedGrantTypes = GrantTypes.ResourceOwnerPassword,
                    AllowedScopes = new []
                    {
                        "openid",
                        "zkybe.users",
                        "zkybe.admin"
                    }
                },

            };

        public static IEnumerable<TestUser> Users =>
            new TestUser[]
            {
                new TestUser()
                {
                    SubjectId = "45",
                    Username = "dorel.marcel",
                    Password = "qwerty",
                    Claims = new List<Claim>
                    {
                        new Claim("Role", "0")
                    }
                },
                new TestUser()
                {
                    SubjectId = "2",
                    Username = "gigica",
                    Password = "ceamaifainaparola",
                    Claims = new List<Claim>
                    {
                        new Claim("Role", "1")
                    }
                }
            };

        public static void MigrateInMemoryDataToSqlServer(IApplicationBuilder app)
        {
            using (var scope = app.ApplicationServices.GetService<IServiceScopeFactory>()?.CreateScope())
            {
                if (scope == null)
                {
                    return;
                }

                scope.ServiceProvider.GetRequiredService<PersistedGrantDbContext>().Database.Migrate();

                var context = scope.ServiceProvider.GetRequiredService<ConfigurationDbContext>();

                context.Database.Migrate();

                if (!context.Clients.Any())
                {
                    foreach (var client in Clients)
                    {
                        context.Clients.Add(client.ToEntity());
                    }

                    context.SaveChanges();
                }

                if (!context.ApiScopes.Any())
                {
                    foreach (var apiscope in ApiScopes)
                    {
                        context.ApiScopes.Add(apiscope.ToEntity());
                    }

                    context.SaveChanges();
                }

            }
        }
    }
}
