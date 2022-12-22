using IdentityModel;
using IdentityServer_UAC.Data;
using IdentityServer4.Models;
using IdentityServer4.Validation;
using Microsoft.EntityFrameworkCore;
using System.Security.Claims;

namespace IdentityServer_UAC.Configurations
{
    public class ResourceOwnerPasswordValidator : IResourceOwnerPasswordValidator
    {
        private readonly ZkybeDbContext _dbContext;

        public ResourceOwnerPasswordValidator(ZkybeDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task ValidateAsync(ResourceOwnerPasswordValidationContext context)
        {
            try
            {
                var user = await _dbContext.Users.FirstOrDefaultAsync(u => u.Nickname == context.UserName);
                if (user != null)
                {
                    if (user.Password == context.Password)
                    {
                        context.Result = new GrantValidationResult(
                            subject: user.Id.ToString(),
                            authenticationMethod: "password",
                            claims: GetUserClaims(user));

                        return;
                    }

                    context.Result = new GrantValidationResult(TokenRequestErrors.InvalidGrant, "Incorrect password");
                    return;
                }
                context.Result = new GrantValidationResult(TokenRequestErrors.InvalidGrant, "User does not exist.");
                return;
            }
            catch (Exception ex)
            {
                context.Result = new GrantValidationResult(TokenRequestErrors.InvalidGrant, "Invalid username or password");
            }
        }

        public static Claim[] GetUserClaims(User user)
        {
            return new Claim[]
            {
            new Claim(JwtClaimTypes.Subject, user.Id.ToString()),
            new Claim("username", user.Nickname)

            //roles todo
            // new Claim(JwtClaimTypes.Role, user.Role)
            };
        }
    }
}
